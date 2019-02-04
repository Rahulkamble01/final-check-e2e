import { browser, by, element, promise, ElementFinder, ElementArrayFinder } from 'protractor';

export class ArticlePage {

    getTitle() {
        return element(by.css('h2'));
    }

    getSearchInputField() {
        return element(by.className('form-control mr-sm-2'));
    }

    getSearchButton() {
        return element(by.className('btn btn-outline-success my-2 my-sm-0 search'));
    }

    getSearchArticleTitle() {
        return element(by.id('articleSearch'));
    }

    getSearchArticlesCard() {
        return element.all(by.id('searchArticlesList'));
    }

    getSearchArticlesCardTitles() {
        return element.all(by.className('card-title'));
    }

    getFavouriteArticleButton() {
        return element(by.id('favbutton'));
    }
}
