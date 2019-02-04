// import { async, ComponentFixture, TestBed } from '@angular/core/testing';
// import { BrowserModule, By } from '@angular/platform-browser';
// import { FormsModule, ReactiveFormsModule } from '@angular/forms';
// import { DebugElement } from '@angular/core';

// import { LoginComponent } from './login.component';

// describe('LoginComponent', () => {
//   let component: LoginComponent;
//   let fixture: ComponentFixture<LoginComponent>;
//   let de: DebugElement;
//   let el: HTMLElement;

//   beforeEach(async(() => {
//     TestBed.configureTestingModule({
//       declarations: [LoginComponent],
//       imports: [
//         BrowserModule,
//         FormsModule,
//         ReactiveFormsModule
//       ]
//     })
//       .compileComponents();
//   }));

//   beforeEach(() => {
//     fixture = TestBed.createComponent(LoginComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//     de = fixture.debugElement.query(By.css('form'));
//     el = de.nativeElement;
//   });

//   it('should create', () => {
//     expect(component).toBeTruthy();
//   });

//   it('form should be invalid', () => {
//     component.login.controls['email'].setValue('');
//     component.login.controls['password'].setValue('');
//     // tslint:disable-next-line:no-unused-expression
//     expect(component.login.valid).toBeFalsy;
//   });

//   it('form should be valid', () => {
//     component.login.controls['email'].setValue('');
//     component.login.controls['password'].setValue('');
//     // tslint:disable-next-line:no-unused-expression
//     expect(component.login.valid).toBeFalsy;
//   });


// });

