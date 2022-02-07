import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fruit } from '../_models/fruit';
import { FruitService } from '../_services/fruit.service';
import { TokenStorageService } from '../_services/token-storage.service';
import { UserService } from '../_services/user.service';
import { FormGroup, FormControl, Validators} from '@angular/forms';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  content: string;
  isLoggedIn = false;

  fruits:Fruit[];
  form: FormGroup;
  isTableShow: boolean = false;
  fruit:Fruit;
  currentUser: any;

  constructor(private userService: UserService,private tokenStorageService: TokenStorageService,private router: Router
    , private fruitService:FruitService) { 
      this.getAllFruits();
    }

  ngOnInit(): void {
    this.isTableShow = true;
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    this.userService.getPublicContent().subscribe(
      data => {
        this.content = data;
      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
    this.currentUser = this.tokenStorageService.getUser();
    console.log("User Info", this.currentUser.email);
    this.form = new FormGroup({
      customer_name: new FormControl('', [Validators.required]),
      customer_phoneNumber: new FormControl('', Validators.required),
      fruit_name: new FormControl('', [Validators.required]),
      amount: new FormControl('', Validators.required),
      balance_amount: new FormControl('', [Validators.required]),
      boxCount: new FormControl('', Validators.required)
    });
  }

  logout(): void {
    this.tokenStorageService.signOut();
    this.router.navigate(["/"]);
  }
  get f(){
    return this.form.controls;
  }

  submitFruit(){
    let userInfo : any = this.tokenStorageService.getUser;
    let user :any ={
      "id":this.currentUser.id,
      "username":this.currentUser.username,
      "email": this.currentUser.email
    }
    console.log("User Info", userInfo);
    this.fruit ={
    
      "customer_name" : this.form.value.customer_name,
      "customer_phoneNumber": this.form.value.customer_phoneNumber,
      "fruit_name":this.form.value.fruit_name,
      "amount":this.form.value.amount,
      "balance_amount":this.form.value.balance_amount,
      "boxCount":this.form.value.boxCount,
      "user":user
    }
    
    console.log("Create Sale data: ",this.fruit);
    this.fruitService.create(this.fruit).subscribe(res => {
         console.log('Sale created successfully!');
         this.isTableShow = true;
         this.getAllFruits();
    })
  }
  deleteFruit(id){

  }
  updateFruit(id){

  }
  fruitDetails(id){
  }

  createFruit(){
    this.isTableShow = false;
    
  }
  getAllFruits(){
    this.fruitService.getAll().subscribe((data: Fruit[])=>{
      this.fruits = data;
      console.log(this.fruits);
    });
  }
}
