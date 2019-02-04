import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class SignUpPage {

    navigateToLoginPage() {
        return browser.get('/');
    }

    getSignUpButton() {
        return element(by.className('btn btn-primary signup-btn'));
    }

    getSubmitButton() {
        return element(by.className('btn btn-success btn-block'));
    }
    sendNameForSignUp() {
        return element(by.id('loginemail'));
    }

    sendEmailForSignUp() {
        return element(by.id('loginpassword'));
    }

    sendPasswordForSignUp() {
        return element(by.id('loginpassword'));
    }

    sendLanguageForSignUp() {
        return element(by.id('signuplanguage'));
    }

    getLoginButton() {
        return element(by.className('btn btn-primary btn-block signup-btn float-right'));
    }

    getErrorMessage() {
        return element(by.className('col form-group alert alert-danger'));
    }

    getSignupModal() {
        return element(by.className('modal fade'));
    }

    getSignupSuccessMessage() {
        return element(by.className('col form-group alert alert-success'));
    }

}
