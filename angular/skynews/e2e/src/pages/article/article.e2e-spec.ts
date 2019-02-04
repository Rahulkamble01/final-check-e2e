import { LoginPage } from '../login/login.po';
import { protractor, browser } from 'protractor';
import { ArticlePage } from './article.po';
describe('Article Page', () => {
    let page: ArticlePage;
    let loginPage: LoginPage;
   //  let firstCard: any;
    // tslint:disable-next-line:label-position

    const EC = protractor.ExpectedConditions;

    beforeEach(() => {
        page = new ArticlePage();
        loginPage = new LoginPage();

        loginPage.navigateToLoginPage();
        loginPage.sendEmailForLogin().sendKeys('kiran@gmail.com');
        loginPage.sendPasswordForLogin().sendKeys('A123456');
        loginPage.getLoginButton().click();
        browser.wait(EC.visibilityOf(page.getTitle()));

    });


    it('should be able to login and then  display Top Headlines ', () => {
        expect(page.getTitle().isPresent()).toBeTruthy();
        expect(page.getTitle().getText()).toBe('Top Headlines');
        expect(browser.driver.getCurrentUrl()).toContain('/article');
    });

    it('should be able to login and  should be able to search articles based on keywords', () => {
        expect(page.getTitle().isPresent()).toBeTruthy();
        page.getSearchInputField().sendKeys('india');
        page.getSearchButton().click();
        browser.wait(EC.visibilityOf(page.getSearchArticleTitle()));
        expect(page.getSearchArticleTitle().isPresent()).toBeTruthy();
        expect(page.getSearchArticleTitle().getText()).toBe('Search Result for "india"');
        expect(page.getSearchArticlesCard().isDisplayed()).toBeTruthy();
        expect(browser.driver.getCurrentUrl()).toContain('/article');
    });

    // it('should be able to login and mark article as favourite', () => {
    //     expect(page.getTitle().isPresent()).toBeTruthy();
    //     firstCard = page.getSearchArticlesCard().get(0);
    //     page.getFavouriteArticleButton().click();
    //     expect(browser.driver.getCurrentUrl()).toContain('/article');
    // });
});


