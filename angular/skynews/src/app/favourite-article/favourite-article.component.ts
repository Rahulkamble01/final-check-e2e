import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { AdminService } from '../admin.service';
import { ArticleService } from '../article.service';

@Component({
  selector: 'app-favourite-article',
  templateUrl: './favourite-article.component.html',
  styleUrls: ['./favourite-article.component.css']
})
export class FavouriteArticleComponent implements OnInit {
  userData: any;
  artcileList: any = [];

  constructor(private service: AuthService, private articleService: ArticleService) { }

  ngOnInit() {
    this.userData = this.service.getUserData();
    // this.userData = JSON.parse(sessionStorage.getItem('currentUser'));
    // this.artcileList = this.userData.articles;
    this.articleService.getFavArticles(this.userData.email).subscribe(data => {
      this.artcileList = data.articles;
    });
  }

}
