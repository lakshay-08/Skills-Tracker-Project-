import { Component, OnInit } from '@angular/core';
import {Associate} from '../associate';
import {AssociateService} from '../associate.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-create-associate',
  templateUrl: './create-associate.component.html',
  styleUrls: ['./create-associate.component.css']
})
export class CreateAssociateComponent implements OnInit {

  // @ts-ignore
  associate: Associate = new Associate();
  submitted = false;
  constructor(private associateService: AssociateService,
              private router: Router) { }

  ngOnInit() {
  }
  newAssociate() {
    this.submitted = false;
    // @ts-ignore
    this.associate = new Associate();
  }
  save() {
    this.associateService.createAssociate(this.associate)
      .subscribe(data => console.log(data), error => console.log(error));
    // @ts-ignore
    this.associate = new Associate();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/associates']);
  }
}
