import { LoginPage } from './login.po';
import { protractor, browser } from 'protractor';
import { ArticlePage } from '../article/article.po';
describe('Login page', () => {
    let page: LoginPage;
    // tslint:disable-next-line:label-position
     const article = new ArticlePage();
    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new LoginPage();
        page.navigateToLoginPage();
    });


    it('should be able to login', () => {
        page.sendEmailForLogin().sendKeys('kiran@gmail.com');
        page.sendPasswordForLogin().sendKeys('A123456');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(article.getTitle()));
        expect(article.getTitle().isPresent()).toBeTruthy();
        expect(browser.driver.getCurrentUrl()).toContain('/article');
    });

    it('should be not be able to login if email is wrong', () => {
        page.sendEmailForLogin().sendKeys('emaail@gmail.com');
        page.sendPasswordForLogin().sendKeys('A123456');
        page.getLoginButton().click();
        browser.wait(EC.visibilityOf(page.getErrorMessage()));
        expect(page.getErrorMessage().getText()).toBe('Invalid Email Id or Password.');
    });
});



// https://trailheadtechnology.com/ui-automation-testing-of-angular-apps-using-protractor-jasmine/
// https://scotch.io/@charlieoduk/angular-end-to-end-testing507

// https://coryrylan.com/blog/introduction-to-e2e-testing-with-the-angular-cli-and-protractor


// --- Karma

// https://scotch.io/tutorials/testing-angular-with-jasmine-and-karma-part-1
