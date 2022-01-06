import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA} from '@angular/material/dialog';

@Component({
  // tslint:disable-next-line:component-selector
  selector: 'dialog-winner',
  templateUrl: './dialogWinner.html'
})
export class DialogWinner {
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) {
  }
}
