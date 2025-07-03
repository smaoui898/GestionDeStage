// login.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faEnvelope, faLock, faArrowRight, faShieldAlt, faUserGraduate, faTasks, faUserTie, faChartBar } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, FontAwesomeModule],
  templateUrl: './login.html',
  styleUrls: ['./login.css']
})
export class Login {
  // Font Awesome icons
  faEnvelope = faEnvelope;
  faLock = faLock;
  faArrowRight = faArrowRight;
  faShieldAlt = faShieldAlt;
  faUserGraduate = faUserGraduate;
  faTasks = faTasks;
  faUserTie = faUserTie;
  faChartBar = faChartBar;

  // Form model
  loginForm = {
    email: '',
    password: ''
  };

  onSubmit() {
    // Handle login logic here
    console.log('Login form submitted', this.loginForm);
  }
}