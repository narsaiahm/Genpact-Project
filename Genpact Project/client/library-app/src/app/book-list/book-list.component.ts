import { Router ,ActivatedRoute} from '@angular/router';
import { BookService } from './../book.service';
import { Component, OnInit } from '@angular/core';
import { Books } from "../domain/Books";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css']
})
export class BookListComponent implements OnInit {
  books: any;
  successMsg:String;
  errorMsg:String;

  constructor(private bookService:BookService,private router : Router,private activateRouter:ActivatedRoute) { }

  ngOnInit(): void {
    let response = this.bookService.getBooksList(); 

    response.subscribe ((data)=> {this.books=data;
      console.log(data);
    }
    );
  }

  ngOnViewInit(){
    let response = this.bookService.getBooksList(); 
    response.subscribe ((data)=> {this.books=data;
      console.log(data);
    }
    );
  }

  deleteBook(bookId:number){
    console.log("bookId"+bookId);
    let resp = this.bookService.deleteBook(bookId);
    resp.subscribe((resp: any) => {
      console.log("added successfulluy");
      this.successMsg = 'The Book with ID: '+bookId+ '  is Deleted Successfully.';
   }, (error1: any) => {
       this.errorMsg = 'The form was not submitted. Please try again.';
        });
  }

  gotoDetails(bookId: number) {
    console.log("BookID"+bookId);
    this.router.navigate(['editBook/', bookId]);
  }

}
