import { Component, OnInit } from '@angular/core';
import {Observable} from 'rxjs';
import {Associate} from '../associate';
import {AssociateService} from '../associate.service';
import {Router} from '@angular/router';
import {Skill} from '../skill';

@Component({
  selector: 'app-skill-list',
  templateUrl: './skill-list.component.html',
  styleUrls: ['./skill-list.component.css']
})
export class SkillListComponent implements OnInit {

  skills: Observable<Skill[]>;

  constructor(private associateService: AssociateService,
              private router: Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData() {
    this.skills = this.associateService.getSkills();
  }
}
