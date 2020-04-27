import { BookService } from './../book.service';
import { Component, OnInit } from '@angular/core';
import { Books } from "../domain/Books";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {
  book: Books=new Books();

  bookTitle :string;
  bookCover :string;
  bookPublisher :string;
  bookPages :number
  bookAvailable :number;
  finalErrorMessage :String;
  successMsg:String;
  constructor(private bookService:BookService) { }

  ngOnInit(): void {
  }
  submitAddBook(){
  console.log(this.book.title);
    if(this.book.title == undefined || this.book.cover == undefined || this.book.publisher == undefined || this.book.pages == undefined || this.book.available == undefined){
      return  this.finalErrorMessage = 'Please provide all the mandatory fields.';
    } else {
   this.bookService.addNewBook(this.book).subscribe(resp => {
                    this.successMsg = 'The New Book is added successfully.';
                   }, error1 => {
                       this.finalErrorMessage = 'The form was not submitted. Please try again.';
                        });
    }
  }
}
