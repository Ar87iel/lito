import { RouterModule, Routes} from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { BodyComponent } from './components/body/body.component';
import { FooterComponent } from './components/footer/footer.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';

const APP_ROUTES: Routes = [
  {path: 'home', component: HomeComponent },
  {path: 'body', component: BodyComponent },
  {path: 'footer', component: FooterComponent },
  {path: 'navbar', component: NavbarComponent },
  {path: 'sidebar', component: SidebarComponent },
  {path: 'login', component: LoginComponent },
  {path: 'register', component: RegisterComponent },
  {path: '**', pathMatch: 'full', redirectTo: 'home'}
];

export const  APP_ROUTING = RouterModule.forRoot(APP_ROUTES);
