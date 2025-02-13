async function getEmployees() {
    try {
        const response = await fetch('http://localhost:8080/api/v1/employee/allEmployee');
        if (!response.ok) {
            throw new Error('Ответ пришёл с ошибкой ' + response.status);
        }
        const employees = await response.json();
        return employees;
    } catch (error) {
        console.error('Ошибка при получении данных: ', error);
        return [];
    }
}

async function getPosition(positionId) {
    try {
        const response = await fetch('http://localhost:8080/api/v1/position/getPosition/' + positionId);
        if (!response.ok) {
            throw new Error('Ответ пришёл с ошибкой ' + response.status);
        }
        const position = await response.json();
        return position;
    } catch (error) {
        console.error('Ошибка при получении данных ', error);
        return [];
    }
}

function createEmployeeBlock(employee, position) {
    const employeeBlock = document.createElement('div');
    employeeBlock.classList.add('employee-block');

    const FIElement = document.createElement('h3');
    FIElement.textContent = employee.surname + ' ' + employee.firstname;
    FIElement.classList.add('FIO');

    const OElement = document.createElement('h3');
    OElement.textContent = employee.patronymic;

    const positionElement = document.createElement('p');
    positionElement.textContent = position.name;
    positionElement.classList.add('position');

    const emailElement = document.createElement('p');
    emailElement.textContent = employee.email;
    emailElement.classList.add('email');

    const telephoneElement = document.createElement('p');
    telephoneElement.textContent = employee.telephone;
    telephoneElement.classList.add('telephone');

    const date = new Date(employee.dateOfBirth);
    const day = date.getDate();
    const month = date.getMonth();
    let monthName;
    if (month == 0) {
        monthName = 'Января';
    }
    if (month == 1) {
        monthName = 'Февраля';
    }
    if (month == 2) {
        monthName = 'Марта';
    }
    if (month == 3) {
        monthName = 'Апреля';
    }
    if (month == 4) {
        monthName = 'Мая';
    }
    if (month == 5) {
        monthName = 'Июня';
    }
    if (month == 6) {
        monthName = 'Июля';
    }
    if (month == 7) {
        monthName = 'Августа';
    }
    if (month == 8) {
        monthName = 'Сентября';
    }
    if (month == 9) {
        monthName = 'Октября';
    }
    if (month == 10) {
        monthName = 'Ноября';
    }
    if (month == 11) {
        monthName = 'Декабря';
    }

    const dateElement = document.createElement('p');
    dateElement.textContent = day + ' ' + monthName;
    dateElement.classList.add('date');

    employeeBlock.appendChild(FIElement);
    employeeBlock.appendChild(OElement);
    employeeBlock.appendChild(positionElement);
    employeeBlock.appendChild(emailElement);
    employeeBlock.appendChild(telephoneElement);
    employeeBlock.appendChild(dateElement);

    return employeeBlock;
}

async function displayEmployees() {
    const employees = await getEmployees();
    const employeeContainer = document.getElementById('employee-container');

    for (const employee of employees) {
        const position = await getPosition(employee.positionId);
        const employeeBlock = createEmployeeBlock(employee, position);
        employeeContainer.appendChild(employeeBlock);
    }
}

async function getEvents() {
    try {
        const response = await fetch('http://localhost:8080/api/v1/event/allEvent');
        if (!response.ok) {
            throw new Error('Ошибка в ответе ' + response.status);
        } else {
            const event = await response.json();
            return event;
        }
    } catch (error) {
        console.error('Ошибка отправки запроса', error);
        return [];
    }
}

function createEventBlock(event) {
    const eventBlock = document.createElement('div');
    eventBlock.classList.add('event-block');

    const nameElement = document.createElement('h3');
    nameElement.classList.add('event-name');
    nameElement.textContent = event.name;

    const discriptionElement = document.createElement('p');
    discriptionElement.classList.add('event-discription');
    discriptionElement.textContent = event.discription;

    const dateElement = document.createElement('p');
    dateElement.classList.add('event-date');

    const buttonElement = document.createElement('button');
    buttonElement.classList.add('calendar-button');

    const calendarImage = document.createElement('img');
    calendarImage.src = '/img/Calendar.jpg';
    calendarImage.alt = 'Календарь';
    
    buttonElement.appendChild(calendarImage);

    const mainDateElement = document.createElement('div');
    mainDateElement.appendChild(buttonElement);
    mainDateElement.appendChild(dateElement);
    mainDateElement.classList.add('main-date-element');
    
    const date = new Date(event.dateTime);
    let finalDate;
    if (date.getMonth() + 1 < 10 && date.getDay() + 1 < 10) {
        finalDate = '0' + (date.getDay() + 1) + '.0' + (date.getMonth() + 1) + '.' + date.getFullYear();
    } else {
        if (date.getMonth() + 1 < 10) {
            finalDate = (date.getDay() + 1) + '.0' + (date.getMonth() + 1) + '.' + date.getFullYear();
        } else {
            if (date.getDay() + 1 < 10) {
                finalDate = '0' + (date.getDay() + 1) + '.' + (date.getMonth() + 1) + '.' + date.getFullYear();
            }
        }
    }

    dateElement.textContent = finalDate;

    eventBlock.appendChild(nameElement);
    eventBlock.appendChild(discriptionElement);
    eventBlock.appendChild(mainDateElement);

    return eventBlock;
}

async function displayEvents() {
    const events = await getEvents();
    const eventContainer = document.getElementById('event-container');

    for (const event of events) {
        const eventBlock = createEventBlock(event);
        eventContainer.appendChild(eventBlock);
    }
}

// Вызов функций при прогрузке страницы
document.addEventListener('DOMContentLoaded', displayEmployees);
document.addEventListener('DOMContentLoaded', displayEvents);