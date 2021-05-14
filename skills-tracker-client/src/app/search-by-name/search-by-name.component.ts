import { Component, OnInit } from '@angular/core';
import {AssociateService} from '../associate.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Associate} from '../associate';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-search-by-name',
  templateUrl: './search-by-name.component.html',
  styleUrls: ['./search-by-name.component.css']
})
export class SearchByNameComponent implements OnInit {

  associateName: string;
  associate: Associate;
  associates: Observable<Associate[]>;

  constructor(private route: ActivatedRoute, private associateService: AssociateService,
              private router: Router) { }

  ngOnInit() {
    // @ts-ignore
    this.associate = new Associate();

    this.associateName = this.route.snapshot.params['associateName'];

    this.associateService.getAssociatesByName(this.associateName)
      .subscribe(data => {
        console.log(data);
        this.associate = data;
      }, error => console.log(error));
    this.associateDetailsByName(this.associateName);
  }
  reloadData() {
    this.associates = this.associateService.getAssociatesList();
  }
  associateDetailsByName(associateName: string) {
    this.router.navigate(['associateName', associateName]);
  }
}
