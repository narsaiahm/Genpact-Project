import { EditBookComponent } from './edit-book/edit-book.component';
import { AppComponent } from './app.component';
import { BookListComponent } from './book-list/book-list.component';
import { AddBookComponent } from './add-book/add-book.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
 {path:"",redirectTo:"addBook",pathMatch:"full"},
{path:"addBook",component:AddBookComponent},
{path:"bookList",component:BookListComponent},
{ path: 'editBook', component: EditBookComponent },
{ path: 'editBook/:bookId', component: EditBookComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
