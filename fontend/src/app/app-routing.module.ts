import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddPlayersComponent } from './add-players/add-players.component';
import { GenerateTeamsComponent } from './generate-teams/generate-teams.component';

const routes: Routes = [
  {
    path:'home',
    component: AddPlayersComponent
  },
  {
    path:'generate',
    component: GenerateTeamsComponent
  },
  {
    path:'',
    redirectTo: 'home',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
