# PropertyManagement

Webservice use to help property managers with they work.
Webservice ensure features like:
-	store user data
-	create/ edit/ delete user
-	create/ edit/ delete property
-	create/ edit/ delete announcements for property (current, all, past) 
-	enable users to communicate with admin by notification (new, sent, all)

Main user info
-----------------------------
Role      | Property manager  | Jan Kowalski   |
--------- | ----------------- | -------------- |
Login     | admin1            | Stokrotka1     |
Password  | fun123            | fun123         |

All users login can be read from sql-script file all default password are "fun123".

-----------------------------


## 1. Part permitted to all

### 1.1. Index

 Welcome page. On page bottom is arrow which click will toggle container with basic info of creator of page.
 
![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/1_main_index.png?raw=true)

After arrow click

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/1_main_index_toggle.png?raw=true)

### 1.2. Contact

Contain info about property manager and how to contact with him.

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/2_main_contact.png?raw=true)

### 1.3. Login

Login page. Will always show up when url will be like /user/.* or /manager/.*

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/3_main_login.png?raw=true)

Invalid username or password during login

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/3_main_login_unexisting.png?raw=true)

## 2. Part permitted to user with role of inhabitant 

### 2.1. User

Welcome page after login

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/4_user.png?raw=true)

#### Logout 

By clicking "Wyloguj" button user will be log out 

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/9_user_logout.png?raw=true)

Page after logout

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/9_user_logout_after.png?raw=true)

#### User data edit

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/5_user_edit.png?raw=true)

User data edit error show up when input data are not correct

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/5_user_edit_error.png?raw=true)

#### User password change

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/6_user_edit_password.png?raw=true)

User password change error are shown when old password don't match store password and/or new passwords not match each other

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/6_user_edit_password_error.png?raw=true)

### 2.2. Property

User can see current and plan announcement of property that he belong to

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/7_user_property.png?raw=true)

All announcements can be click in arrow to display more info

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/7_user_property_toggle.png?raw=true)

User can see all announcement of property that he belong to

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/7_user_property_all.png?raw=true)

User can see past announcement of property that he belong to

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/7_user_property_past.png?raw=true)

User can see managers of property that he belong to

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/7_user_property_managers.png?raw=true)

### 2.3. Notification

User can communicate with property manager by sending notification.

Main notification page, which show new notifications. New mean that property manager sent new notification to user or response to previous one.

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/8_user_notification.png?raw=true)

All notification page (both sent and received)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/8_user_notification_all.png?raw=true)

Creating new notification

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/8_user_notification_new.png?raw=true)

New notification must contain title and text.

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/8_user_notification_new_error.png?raw=true)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/8_user_notification_new_sent.png?raw=true)

After send, new notification will show in sent notification page

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/8_user_notification_sent.png?raw=true)

All notification can be toggle, which will show all response messages. After toggle user can response to all notification and unmark notification only if notification is mark as new

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/8_user_notification_toggle.png?raw=true)

Writing response

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/8_user_notification_toggle_response.png?raw=true)

Response error, cannot be empty

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/8_user_notification_toggle_response_error.png?raw=true)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/8_user_notification_toggle_response_sent.png?raw=true)

Response to notification after sent.

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/8_user_notification_toggle_response_sent_toggle.png?raw=true)

## 3. Part permitted to admin (property manager)

### 3.1. Manager

### Login

Login as admin (Property manager)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/10_manager_login.png?raw=true)

Main page

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/10_manager_login_after.png?raw=true)

### 3.1.1. Property manager 

#### Edit manager data

Manager can edit his data, validation is the same like in user data edit

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/11_manager_edit.png?raw=true)

Updated data

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/11_manager_edit_after.png?raw=true)

#### Edit manager password

Manager also may change password, validation is the same like in user password edit

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/11_manager_edit_password.png?raw=true)

### 3.1.2. Property manager properties

Manager can see all properties which he manage

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/12_manager_manager_property.png?raw=true)

By clicking arrow more info about property will show

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/12_manager_manager_property_toggle.png?raw=true)

All properties can be edit (pencil icon)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/12_manager_manager_property_edit_click.png?raw=true)

Manager can add new property

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/13_manager_manager_property_add_click.png?raw=true)

Name and address of property cannot be null/empty both in save and update

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/13_manager_manager_property_add_click_error.png?raw=true)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/13_manager_manager_property_add_new_property.png?raw=true)

New property after adding 

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/13_manager_manager_property_add_new_property_after.png?raw=true)

When delete button (trash can icon) is click the confirmation window will show. Clicking ok will delete property.

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/14_manager_manager_property_delete_confirmation.png?raw=true)

After OK

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/14_manager_manager_property_delete_confirmation_yes.png?raw=true)

### 3.1.3. Property manager users

All user page

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/15_manager_manager_users.png?raw=true)

More info of user will show by clicking arrow

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/15_manager_manager_users_toggle.png?raw=true)

Every user can be edit (pencil icon)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/15_manager_manager_users_edit_click.png?raw=true)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/15_manager_manager_users_edit_click_v1.png?raw=true)

User after edit

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/15_manager_manager_users_edit_click_after.png?raw=true)

Users can be search depending on property which they live in 

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/16_manager_manager_users_search_property.png?raw=true)

All users that live in property "Stokrotka"

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/16_manager_manager_users_search_property_after.png?raw=true)

Users can be search by first name, last name or both 

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/16_manager_manager_users_search_by_name.png?raw=true)

Manager can create new user 

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/17_manager_manager_users_new.png?raw=true)

Creating and updating user must past validation

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/17_manager_manager_users_new_error.png?raw=true)

New user data

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/17_manager_manager_users_new_user.png?raw=true)

After creating new user or generate users, for one time will be display login and password which property manager must save and send to user/s.
User should change granted password after 1 login.

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/17_manager_manager_users_new_user_after.png?raw=true)

New created user

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/17_manager_manager_users_new_user_show.png?raw=true)

Manager can generate any number of user profiles, after choosing property and giving profiles amount

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/18_manager_manager_users_generate_user_fill.png?raw=true)

Generated user profiles logins and passwords

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/18_manager_manager_users_generate_user_after.png?raw=true)

New profiles in property

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/18_manager_manager_users_generate_user_after_show.png?raw=true)


### 3.2. Property

Manager can create/ edit and delete announcement for selected property

Main property page - current announcement for first created property 

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/19_manager_property.png?raw=true)

Manager can change property which shown announcement are connected to by choosing property from top left corner list

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/19_manager_property_select.png?raw=true)

For more announcement info click arrow 

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/19_manager_property_toggle.png?raw=true)

All announcement for chosen property

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/19_manager_property_all.png?raw=true)

By clicking pencil icon all announcement can be edit 

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/19_manager_property_edit.png?raw=true)

Access to all managers of property. Managers can be changed by the main Property Manager, editing user profile and changing role

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/19_manager_property_managers.png?raw=true)

Manager can create new announcement (will be added to choosen property [top-left corner])

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/19_manager_property_new.png?raw=true)

New and edit property must pass validation

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/19_manager_property_new_error.png?raw=true)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/19_manager_property_new_fill.png?raw=true)

Added announcement

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/19_manager_property_new_after.png?raw=true)

Past announcement

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/19_manager_property_past.png?raw=true)

### 3.3. Notification

Notification is base way to communicate between single user and property manager.

Manager notification main page (new - which mean that user sent to manager new notification or respond to previous one)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/20_manager_notification.png?raw=true)

By clicking "oznacz jako przeczytane" manager can remove notification from new page (don't redirect mark to user)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/20_manager_notification_toggle_mark.png?raw=true)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/20_manager_notification_toggle_mark_after.png?raw=true)

Manager can sort notification by user 

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/21_manager_notification_search.png?raw=true)

Manager can sort user list by selecting property

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/21_manager_notification_search_property.png?raw=true)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/21_manager_notification_search_property_user.png?raw=true)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/21_manager_notification_search_property_user_after.png?raw=true)

By clicking arrow more info about notification will show, and manager will be able to respond and (only in new page) mark notification as read

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/22_manager_notification_many_toggle.png?raw=true)

Writing response to notification (click response button)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/22_manager_notification_many_toggle_response.png?raw=true)

Response must past validation

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/22_manager_notification_many_toggle_response_error.png?raw=true)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/22_manager_notification_many_toggle_response_fill.png?raw=true)

Sent response

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/22_manager_notification_many_toggle_response_after.png?raw=true)

Manager can see all notification (both sent and new include)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/23_manager_notification_all.png?raw=true)

Manager can send new notification to any user (user must be selected)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/24_manager_notification_new.png?raw=true)

Changing property change user list

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/24_manager_notification_new_property.png?raw=true)

Manager must select receiver from list

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/24_manager_notification_new_user.png?raw=true)

New notification must past validation

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/24_manager_notification_new_error.png?raw=true)

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/24_manager_notification_new_fill.png?raw=true)

New sent notification 

![](https://github.com/Maciej333/PropertyManagement/blob/master/documentation-photos/24_manager_notification_new_after_send.png?raw=true)
