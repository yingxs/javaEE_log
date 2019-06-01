import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

// 引入表单相关的模块，才可以实现双向数据绑定
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { FormComponent } from './components/form/form.component';

@NgModule({
  declarations: [
    AppComponent,
    FormComponent
  ],
  imports: [
    BrowserModule,FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
