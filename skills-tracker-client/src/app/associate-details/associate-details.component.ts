import { Component, OnInit } from '@angular/core';
import {Associate} from '../associate';
import {ActivatedRoute, Router} from '@angular/router';
import {AssociateService} from '../associate.service';

@Component({
  selector: 'app-associate-details',
  templateUrl: './associate-details.component.html',
  styleUrls: ['./associate-details.component.css']
})
export class AssociateDetailsComponent implements OnInit {

  associateId: number;
  associate: Associate;

  constructor(private route: ActivatedRoute, private router: Router,
              private associateService: AssociateService) { }

  ngOnInit() {

    // @ts-ignore
    this.associate = new Associate();

    this.associateId = this.route.snapshot.params.associateId;

    this.associateService.getAssociate(this.associateId)
      .subscribe(data => {
        console.log(data);
        this.associate = data;
      }, error => console.log(error));
  }

  list() {
    this.router.navigate(['associates']);
  }

}
