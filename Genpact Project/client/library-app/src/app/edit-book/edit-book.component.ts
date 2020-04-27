import { BookService } from './../book.service';
import { ActivatedRoute } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Books } from "../domain/Books";

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {
 bookId:any;
 book: any = new Books();
 successMsg:String;
 finalErrorMessage:String;
  constructor(private activatedRoute:ActivatedRoute,private bookService : BookService) { 

    this.bookId = this.activatedRoute.snapshot.params.bookId;
    console.log("edit bootk bookId : "+this.bookId);

  }

  ngOnInit(): void {
    this.getBookInfoById(this.bookId);
  }

  getBookInfoById(bookId){
    
console.log('Insode Edit Book : '+bookId);
if(bookId == undefined){
return  this.finalErrorMessage = 'Please navigate throw Books List page. Please try again.';
} else {
let response = this.bookService.getBookInfoById(bookId);
response.subscribe(resp => {
  
  this.book =resp
  console.log("this.book"+this.book);
 
 }, error => {
     this.finalErrorMessage = 'The form was not submitted. Please try again.';
      });
  }
}

  updateBook(book){

console.log("Update bookId :"+book);
this.bookService.updateBookInfo(book).subscribe( resp => {
  console.log(resp);
 this.successMsg = "Edit Book Details Successfully."

}, error1 => {
  this.finalErrorMessage = 'The book details are not updated . Please try again.';
   });


  }

  }
  
