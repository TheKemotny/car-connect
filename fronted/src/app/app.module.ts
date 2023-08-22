import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './components/app/app.component';
import { TopBarComponent } from './components/top-bar/top-bar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import {MatButtonToggleModule} from "@angular/material/button-toggle";
import {CarsComponent} from "./components/cars/cars.component";
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {HttpClientModule} from "@angular/common/http";
import { ClientsComponent } from './components/clients/clients.component';
import { AboutComponent } from './components/about/about.component';
import { RentsHistoryComponent } from './components/rents-history/rents-history.component';
import {RouterModule, Routes} from "@angular/router";
import {aboutUrl, carsUrl, clientsUrl, homePageUrl, notFoundUrl, rentsHistoryUrl} from "./models/urls";
import { HomeComponent } from './components/home/home.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import {MatDividerModule} from "@angular/material/divider";
import {MatIconModule} from "@angular/material/icon";

const routingTable: Routes = [
  {path: homePageUrl, component: HomeComponent},
  {path: rentsHistoryUrl, component: RentsHistoryComponent},
  {path: carsUrl, component: CarsComponent},
  {path: clientsUrl, component: ClientsComponent},
  {path: aboutUrl, component: AboutComponent},
  {path: notFoundUrl, component: NotFoundComponent}
]

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    NavBarComponent,
    CarsComponent,
    ClientsComponent,
    AboutComponent,
    RentsHistoryComponent,
    HomeComponent,
    NotFoundComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatButtonToggleModule,
    MatCardModule,
    MatButtonModule,
    RouterModule.forRoot(routingTable),
    MatIconModule,
    MatDividerModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
