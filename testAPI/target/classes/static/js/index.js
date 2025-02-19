async function getEmployees() {
    try {
        const response = await fetch('http://localhost:8080/api/v1/allEmployee');
        const employees = await response.json();
        return employees;
    } catch (error) {
        console.error(error);
        return [];
    }
}

async function getEvents() {
    try {
        const response = await fetch('http://SRV-1208-1:8080/events');
        const events = await response.json();
        return events;
    } catch (error) {
        console.error(error);
        return [];
    }
}

async function getPosition(positionId) {
    try {
        const response = await fetch('http://localhost:8080/api/v1/positionById/' + positionId);
        const positions = await response.json();
        return positions;
    } catch (error) {
        console.error(error);
        return [];
    }
}

async function rssFeed() {
    try {
        const newsContainer = document.getElementById('newsContainer');
        const response = await fetch('http://SRV-1208-1:8080/newsrss');
        const xmlText = await response.text();

        const parser = new DOMParser();
        const xmlDoc = parser.parseFromString(xmlText, "application/xml");

        const items = xmlDoc.querySelectorAll('item');

        for (item of items) {
            const title = item.querySelector('title').textContent;
            const description = item.querySelector('description').textContent;
            const date = new Date(item.querySelector('pubDate').textContent);

            const newContainer = document.createElement('div');
            newContainer.classList.add('newContainer');
            
            const imgSection = document.createElement('div');
            imgSection.classList.add('imgSection');
            
            const bottomSection = document.createElement('div');
            bottomSection.classList.add('bottomSection');

            const titleElement = document.createElement('h3');
            titleElement.textContent = title;

            const descriptionElement = document.createElement('p');
            descriptionElement.textContent = description;
            
            bottomSection.append(titleElement);
            bottomSection.append(descriptionElement);

            const dateElement = document.createElement('p');
            dateElement.classList.add('date');

            if (date.getDate() < 10 && (date.getMonth()+1) < 10) {
                dateElement.textContent = '0' + date.getDate() + '.0' + (date.getMonth()+1) + '.' + date.getFullYear();
            } else {
                if ((date.getMonth()+1) < 10) {
                    dateElement.textContent = date.getDate() + '.0' + (date.getMonth()+1) + '.' + date.getFullYear();
                } else {
                    if (date.getDate() < 10) {
                        dateElement.textContent = '0' + date.getDate() + '.' + (date.getMonth()+1) + '.' + date.getFullYear();
                    }
                }
            }

            newContainer.append(imgSection);
            newContainer.append(bottomSection);
            newContainer.append(dateElement);

            newsContainer.append(newContainer);
        }
    } catch (error) {
        console.error(error);
    }
}

function createEmployeeContainer(employee, position) {
    const employeeContainerElement = document.createElement('div');
    employeeContainerElement.classList.add('employeeContainer');

    const FIElement = document.createElement('h3');
    FIElement.textContent = employee.surname + ' ' + employee.firstname;

    const OElement = document.createElement('h3');
    OElement.textContent = employee.middlename;

    const emailElement = document.createElement('p');
    emailElement.textContent = employee.email;
    emailElement.classList.add('email');

    const telephoneElement = document.createElement('p');
    telephoneElement.textContent = employee.telephone;
    telephoneElement.classList.add('telephone');

    const positionElement = document.createElement('p');
    positionElement.textContent = position.name;
    positionElement.classList.add('position');

    const dateElement = document.createElement('p');
    dateElement.classList.add('date');

    const date = new Date(employee.dateOfBirth);

    if (date.getMonth() == 0) {
        dateElement.textContent = date.getDate() + ' января';
    }
    if (date.getMonth() == 1) {
        dateElement.textContent = date.getDate() + ' февраля';
    }
    if (date.getMonth() == 2) {
        dateElement.textContent = date.getDate() + ' марта';
    }
    if (date.getMonth() == 3) {
        dateElement.textContent = date.getDate() + ' апрель';
    }
    if (date.getMonth() == 4) {
        dateElement.textContent = date.getDate() + ' май';
    }
    if (date.getMonth() == 5) {
        dateElement.textContent = date.getDate() + ' июнь';
    }
    if (date.getMonth() == 6) {
        dateElement.textContent = date.getDate() + ' июль';
    }
    if (date.getMonth() == 7) {
        dateElement.textContent = date.getDate() + ' август';
    }
    if (date.getMonth() == 8) {
        dateElement.textContent = date.getDate() + ' сентябрь';
    }
    if (date.getMonth() == 9) {
        dateElement.textContent = date.getDate() + ' октябрь';
    }
    if (date.getMonth() == 10) {
        dateElement.textContent = date.getDate() + ' ноябрь';
    }
    if (date.getMonth() == 11) {
        dateElement.textContent = date.getDate() + ' декабрь';
    }

    employeeContainerElement.append(FIElement);
    employeeContainerElement.append(OElement);
    employeeContainerElement.append(emailElement);
    employeeContainerElement.append(telephoneElement);
    employeeContainerElement.append(positionElement);
    employeeContainerElement.append(dateElement);

    return employeeContainerElement;
}

function createEventContainer(event) {
    const eventContainer = document.createElement('div');
    eventContainer.classList.add('eventContainer');
    
    const titleElement = document.createElement('h3');
    titleElement.textContent = event.title;
    
    const descriptionElement = document.createElement('p');
    descriptionElement.textContent = event.description;
    
    const dateElement = document.createElement('p');
    dateElement.textContent = event.date;
      
    eventContainer.append(titleElement);
    eventContainer.append(descriptionElement);
    eventContainer.append(dateElement);
    
    return eventContainer;
}

async function displayEvents() {
    const events = await getEvents();
    const eventsContainer = document.getElementById('eventsContainer');
    
    for (const event of events) {
        const eventContainer = createEventContainer(event);
        eventsContainer.append(eventContainer);
    }
}

async function displayEmployees() {
    const employees = await getEmployees();
    const employeeContainersElement = document.getElementById('employeeContainers');

    for (employee of employees) {
        const position = await getPosition(employee.positionId);
        const employeeContainerElement = createEmployeeContainer(employee, position);
        employeeContainersElement.append(employeeContainerElement);
    }
}

document.addEventListener('DOMContentLoaded', displayEmployees());
document.addEventListener('DOMContentLoaded', displayEvents());
document.addEventListener('DOMContentLoaded', rssFeed());