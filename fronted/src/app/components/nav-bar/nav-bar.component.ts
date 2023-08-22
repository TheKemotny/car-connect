import { Component } from '@angular/core';
import {aboutUrl, carsUrl, clientsUrl, homePageUrl, rentsHistoryUrl} from "../../models/urls";

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent {

  protected readonly homePageUrl = homePageUrl;
  protected readonly rentsHistoryUrl = rentsHistoryUrl;
  protected readonly carsUrl = carsUrl;
  protected readonly clientsUrl = clientsUrl;
  protected readonly aboutUrl = aboutUrl;
}
