import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {  Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {Fruit} from '../_models/fruit'
const API_URL = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class FruitService {

  constructor(private http: HttpClient) { }

  getfruits(): Observable<any> {
    return this.http.get(API_URL + 'user', { responseType: 'text' });
  }
  getAll(): Observable<Fruit[]> {
    return this.http.get<Fruit[]>(API_URL + 'fruits')
    .pipe(
      catchError(this.errorHandler)
    )
  }
   
  create(fruit): Observable<Fruit> {
    return this.http.post<Fruit>(API_URL + 'createFruit', JSON.stringify(fruit), httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }  
   
  find(id): Observable<Fruit> {
    return this.http.get<Fruit>(API_URL + 'fruits/' + id)
    .pipe(
      catchError(this.errorHandler)
    )
  }
   
  update(id, fruit): Observable<Fruit> {
    return this.http.put<Fruit>(API_URL + 'fruits/' + id, JSON.stringify(fruit), httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }
   
  delete(id){
    return this.http.delete<Fruit>(API_URL + 'fruits/' + id, httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }

  errorHandler(error) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
 }
}