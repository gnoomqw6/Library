//  checking empty or "spacy" values in login field, in password fields and in username field
//  login (e-mail) checks automatically (correct input) in form
//  checking password == passwordRetype

function validateForm() {
    var mail = document.forms["register_form"]["login"].value;
    var pass = document.forms["register_form"]["password"].value;
    var passRe = document.forms["register_form"]["passwordRetype"].value;
    var username = document.forms["register_form"]["username"].value;

    if (mail == null || mail == "" || mail.match(/\s+/)) {
        alert("Логин обязателен для заполнения. Недопустимо использование русских символов и пробелов.");
        return false;
    }

    if (pass == null || pass == "" || pass.match(/^\s+$/)) {
        alert("Пароль обязателен для заполнения. Он НЕ может состоять ТОЛЬКО из пробелов.");
        return false;
    }

    if (pass != passRe) {
        alert("Вы ошиблись при повторе пароля. Будьте внимательней.");
        return false;
    }

    if (username == null || username == "" || username.match(/^\s+$/)) {
        alert("Нам необходимо знать, как к Вам обращаться, поэтому имя обязательно для заполнения. Оно НЕ может состоять ТОЛЬКО из пробелов.");
        return false;
    }

    return true;
}
