import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AssociateService } from '../associate.service';
import { Associate } from '../associate';
import { Router } from '@angular/router';

@Component({
  selector: 'app-associate-list',
  templateUrl: './associate-list.component.html',
  styleUrls: ['./associate-list.component.css']
})
export class AssociateListComponent implements OnInit {

  associates: Observable<Associate[]>;

  constructor(private associateService: AssociateService,
              private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.associates = this.associateService.getAssociatesList();
  }
  deleteAssociate(associateId: number) {
    this.associateService.deleteAssociate(associateId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
  associateDetails(associateId: number) {
    this.router.navigate(['details', associateId]);
  }

  updateAssociate(associateId: number) {
    this.router.navigate(['update', associateId]);
  }
}
