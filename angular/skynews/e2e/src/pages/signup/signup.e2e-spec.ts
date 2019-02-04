
import { protractor, browser } from 'protractor';
import { ArticlePage } from '../article/article.po';
import { SignUpPage } from './signup.po';
describe('Login page', () => {
    let page: SignUpPage;
    // tslint:disable-next-line:label-position
    const article = new ArticlePage();
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new SignUpPage();
        page.navigateToLoginPage();
    });


    it('should be able to signup successfully', () => {
        browser.wait(EC.visibilityOf(page.getSignupModal()));
        expect(page.getSignupModal().isDisplayed()).toBeTruthy();
        page.sendEmailForSignUp().sendKeys('e2etesting@gmail.com');
        page.sendPasswordForSignUp().sendKeys('testing');
        page.sendLanguageForSignUp().sendKeys('English');
        page.getSignUpButton().click();
        browser.wait(EC.visibilityOf(page.getSignupSuccessMessage()));
        expect(page.getSignupSuccessMessage().getText()).toBe('User Signup Successfull');
    });

    it('should be not be able to signup if email already exists', () => {
        browser.wait(EC.visibilityOf(page.getSignupModal()));
        expect(page.getSignupModal().isDisplayed()).toBeTruthy();
        page.sendEmailForSignUp().sendKeys('e2etesting@gmail.com');
        page.sendPasswordForSignUp().sendKeys('testing');
        page.sendLanguageForSignUp().sendKeys('English');
        page.getSignUpButton().click();
        browser.wait(EC.visibilityOf(page.getSignupSuccessMessage()));
        expect(page.getSignupSuccessMessage().getText()).toBe('Email already exist.');
    });
});



// https://trailheadtechnology.com/ui-automation-testing-of-angular-apps-using-protractor-jasmine/
// https://scotch.io/@charlieoduk/angular-end-to-end-testing507


// --- Karma

// https://scotch.io/tutorials/testing-angular-with-jasmine-and-karma-part-1
