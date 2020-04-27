import { Injectable } from '@angular/core';
import { Books } from "./domain/Books";
import { HttpClient ,HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private httpClient: HttpClient) { }

  addNewBook(book){
              
    let data: Books[] = [book];  
      return this.httpClient.post("http://localhost:8080/addBook",data,{headers: new HttpHeaders().set('Content-Type', 'application/json' ) });
 }

 getBooksList() {
  return this.httpClient.get<Books>('http://localhost:8080/getBooks' );
}

deleteBook(bookId:number){
  return this.httpClient.post("http://localhost:8080/delBook/"+ bookId,{headers: new HttpHeaders().set('Content-Type', 'application/json' ) });
}

getBookInfoById(bookId:number){
  return this.httpClient.get("http://localhost:8080/getBookInfo/"+ bookId,{headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Access-Control-Allow-Origin': '*' }) });
}

updateBookInfo(book){
  let data: Books[] = [book];  
      return this.httpClient.post("http://localhost:8080/upateBook",data,{headers: new HttpHeaders().set('Content-Type', 'application/json' ) });
}

}
