import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CandidateList } from './components/candidate-list';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,CandidateList],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('CandidateSystemUI');
}
