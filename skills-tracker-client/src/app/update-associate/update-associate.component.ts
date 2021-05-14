import { Component, OnInit } from '@angular/core';
import {Associate} from '../associate';
import {ActivatedRoute, Router} from '@angular/router';
import {AssociateService} from '../associate.service';

@Component({
  selector: 'app-update-associate',
  templateUrl: './update-associate.component.html',
  styleUrls: ['./update-associate.component.css']
})
export class UpdateAssociateComponent implements OnInit {

  associateId: number;
  associate: Associate;
  submitted: any;

  constructor(private route: ActivatedRoute , private router: Router,
              private associateService: AssociateService) { }

  ngOnInit() {
    // @ts-ignore
    this.associate = new Associate();

    this.associateId = this.route.snapshot.params['associateId'];

    this.associateService.getAssociate(this.associateId)
      .subscribe(data => {
        console.log(data);
        this.associate = data;
      }, error => console.log(error));
  }

  updateAssociate() {
    this.associateService.updateAssociate(this.associateId, this.associate)
      .subscribe(data => console.log(data), error => console.log(error));
    // @ts-ignore
    this.associate = new Associate();
    this.gotoList();
  }

  onSubmit() {
    this.updateAssociate();
  }

  gotoList() {
    this.router.navigate(['/associates']);
  }
}
