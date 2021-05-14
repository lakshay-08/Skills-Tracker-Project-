import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateAssociateComponent } from './create-associate/create-associate.component';
import { AssociateDetailsComponent } from './associate-details/associate-details.component';
import { AssociateListComponent } from './associate-list/associate-list.component';
import { UpdateAssociateComponent } from './update-associate/update-associate.component';
import {FormsModule} from '@angular/forms';
import { SkillListComponent } from './skill-list/skill-list.component';
import { CreateSkillComponent } from './create-skill/create-skill.component';
import { SearchByNameComponent } from './search-by-name/search-by-name.component';
import { SearchResultComponent } from './search-result/search-result.component';

// @ts-ignore
@NgModule({
  declarations: [
    AppComponent,
    CreateAssociateComponent,
    AssociateDetailsComponent,
    AssociateListComponent,
    UpdateAssociateComponent,
    SkillListComponent,
    CreateSkillComponent,
    SearchByNameComponent,
    SearchResultComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
