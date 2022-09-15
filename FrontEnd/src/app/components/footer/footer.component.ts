import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import 'moment/locale/es-mx';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {
  
  constructor() { 
  }

  ngOnInit(): void {
    let time = function() {
      document.getElementById('time').innerHTML = moment().format('LL') + ' - ' + moment().format('LTS') + ' hs'; 
    } 
    setInterval(time, 1000);
  }

}
