document.querySelector('#view').addEventListener('click', e => {
    const passwordInput = document.querySelector('#password');
    if (e.target.classList.contains('show')) {
        e.target.classList.remove('show');
        passwordInput.type = 'text';
        view.style.opacity = 0.8
    } else {
        e.target.classList.add('show');
        passwordInput.type = 'password';
        view.style.opacity = 0.2
    }
});


