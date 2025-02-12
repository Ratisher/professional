let authorizationButton = document.querySelector('#authorizationButton');
let loginInput = document.querySelector('#loginInput');
let passwordInput = document.querySelector('#passwordInput');
authorizationButton.addEventListener('click', function() {
    console.log('Кнопка была нажата');
    const login = loginInput.value;
    const password = passwordInput.value;
    const url = `http://localhost:8080/api/v1/employee/authorization?login=${login}&password=${password}`;
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-type': 'application/json; charset=UTF-8'
        }
    })
            .then(response => {
                if (!response.ok) {
                    console.log('Ошибка: ' + response.status);
                }
                return response.json();
    })
            .then(data => {
                sessionStorage.setItem('employeeID', data.employeeID);
                sessionStorage.setItem('surname', data.surname);
                sessionStorage.setItem('firstname', data.firstname);
                sessionStorage.setItem('patronymic', data.patronymic);
    })
            .catch(error => {
                console.error('Какая-то ошибка', error)
    })
});