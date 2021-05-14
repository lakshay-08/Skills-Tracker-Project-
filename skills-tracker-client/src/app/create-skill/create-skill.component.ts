// @ts-ignore

import { Component, OnInit } from '@angular/core';
import {Associate} from '../associate';
import {AssociateService} from '../associate.service';
import {Router} from '@angular/router';
import {Skill} from '../skill';

@Component({
  selector: 'app-create-skill',
  templateUrl: './create-skill.component.html',
  styleUrls: ['./create-skill.component.css']
})
export class CreateSkillComponent implements OnInit {
  // @ts-ignore
  skill: Skill = new Skill();
  submitted = false;

  constructor(private associateService: AssociateService,
              private router: Router) {
  }

  ngOnInit() {
  }

  newAssociate() {
    this.submitted = false;
    // @ts-ignore
    this.skill = new Skill();
  }

  save() {
    this.associateService.createSkill(this.skill)
      .subscribe(data => console.log(data), error => console.log(error));
    // @ts-ignore
    this.skill = new Skill();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/associates/skills']);

  }
}
