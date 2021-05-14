import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AssociateListComponent} from './associate-list/associate-list.component';
import {CreateAssociateComponent} from './create-associate/create-associate.component';
import {UpdateAssociateComponent} from './update-associate/update-associate.component';
import {AssociateDetailsComponent} from './associate-details/associate-details.component';
import {SkillListComponent} from './skill-list/skill-list.component';
import {CreateSkillComponent} from './create-skill/create-skill.component';
import {SearchByNameComponent} from './search-by-name/search-by-name.component';

const routes: Routes = [
  { path: '', redirectTo: 'associates' , pathMatch: 'full'},
  { path: 'associates', component: AssociateListComponent},
  { path: 'add', component: CreateAssociateComponent},
  { path: 'update/:id', component: UpdateAssociateComponent},
  { path: 'details/:associateId', component: AssociateDetailsComponent},
  { path: 'skills', component: SkillListComponent},
  { path: 'skill', component: CreateSkillComponent},
  { path: 'associateName/:associateName', component: SearchByNameComponent },
  { path: 'result', component: SearchByNameComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
