import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ArticleComponent } from './article/article.component';
import { FavouriteArticleComponent } from './favourite-article/favourite-article.component';
import { AdminComponent } from './admin/admin.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', component: LoginComponent },
  { path: 'article', component: ArticleComponent },
  { path : 'fav', component : FavouriteArticleComponent},
  { path : 'admin', component : AdminComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
