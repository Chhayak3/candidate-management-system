import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule
} from '@angular/forms';

import { CommonModule } from '@angular/common';
import { Candidate } from '../interface/candidate';
import { CandidateService } from '../services/candidate-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-candidate-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './candidate-form.html',
  styleUrls: ['./candidate-form.css']
})
export class CandidateForm implements OnInit {

  candidateForm!: FormGroup;

  
  statusOptions = ['Active', 'On Hold', 'Placed', 'Rejected'];

  modeOptions = ['CTH', 'FTE'];

  constructor(private fb: FormBuilder,private service:CandidateService, private router:Router) {}

  ngOnInit(): void {
    this.initForm();
  }

  initForm(): void {

    this.candidateForm = this.fb.group({

      

      status: ['', Validators.required],

      name: [
        '',
        [
          Validators.required,
          Validators.minLength(2)
        ]
      ],

      experience: [
        null,
        [
          Validators.required,
          Validators.min(0)
        ]
      ],

      noticePeriod: ['', Validators.required],

      primarySkills: ['', Validators.required],

      cell: [
        '',
        [
          Validators.required,
          Validators.pattern('^[0-9]{10}$')
        ]
      ],

      email: [
        '',
        [
          Validators.required,
          Validators.email
        ]
      ],

      location: [
        '',
        [
          Validators.required,
          Validators.pattern(/^[A-Za-z ]+$/)
        ]
      ],

      previousCompany: ['', Validators.required],

      ctc: [
        null,
        [
          Validators.required,
          Validators.pattern(/^\d+(\.\d{1,2})?$/)
        ]
      ],

      ectc: [
        null,
        [
          Validators.required,
          Validators.pattern(/^\d+(\.\d{1,2})?$/)
        ]
      ],

      mode: ['', Validators.required],

      education: ['', Validators.required],

      

      secondarySkills: [''],

      comment: [''],

      clientRound: ['']

    });

  }

  onSubmit(): void {

    if (this.candidateForm.valid) {

      const formData: Candidate = this.candidateForm.value;
      this.service.addCandidate(formData).subscribe({
        next:(res)=>{
          console.log('saved successfully',res);

          this.router.navigate(['/candidates']);
        },

        error:(err)=>{
          console.error('Error saving candidate', err);
        }
      });


    } else {

      this.candidateForm.markAllAsTouched();

    }
  }

  onCancel(): void {

    this.candidateForm.reset();
    this.router.navigate(['/candidates']);

  }

  
  get f() {
    return this.candidateForm.controls;
  }

}