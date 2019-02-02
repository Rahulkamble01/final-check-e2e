import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class ArticlePage {

    getTitle() {
        return element(by.css('h2'));
    }

    sendEmailForLogin() {
        return element(by.id('loginemail'));
    }

    sendPasswordForLogin() {
        return element(by.id('loginpassword'));
    }
    getLoginButton() {
        return element(by.css('btn btn-primary btn-block signup-btn float-right'));
    }

}
