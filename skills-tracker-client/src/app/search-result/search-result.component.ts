import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Associate} from '../associate';
import {AssociateService} from '../associate.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-search-result',
  templateUrl: './search-result.component.html',
  styleUrls: ['./search-result.component.css']
})
export class SearchResultComponent implements OnInit {
  associates: Observable<Associate[]>;

  constructor(private associateService: AssociateService,
              private router: Router) { }

  ngOnInit(): void {
  }

}
