

# Welcome to Leading University Tech Storm v4.0
Before you start working, just to let you know we strive for quality. It means you can use any language, tools, third party services/api, any architecture to show your skills. We will provide requirements that you have to meet to pass, but you can code extra features if you want. Keep in mind don't overdo for the sake of it, prefer high-quality mandatory requirements over many optional features with lower quality. 

We ask you to write a README in Markdown Format and create a presentation of your work to check your communication skills, but also as a chance for you to reason about your implementation decisions. **Please fork this repository and start committing your solution on your fork repository.**

> **Do you wish to provide a non-requirement feature or take a different**
> **project? We can deal with that, as long as you explain the idea. And if**
> **that's a good idea, you can start implementing it when it is accepted by the judge panel**
> :fire::fire::fire:

We hope that everything about the task is clear and if not, we are sorry for that and we are more than happy to clarify anything you did not understand. let us know, and we will get back to you as soon as we can! We wish you good luck! 

## :judge: Judge Panel
- [ ] [Md. Ashiqur Rahman, Software Engineer @Project Protocol @RootSoft IT](https://github.com/mdashikar)
- [ ] [Jaber Ahmed, Software Engineer @yofoodie.co.uk](https://github.com/JABER-AHMED)
- [ ] [Sudipto Chowdhury Dip, Software Engineer @Shohoz Ltd.](https://github.com/sudiptoChy)
- [ ] [Ahmed Maruf, Software Engineer @Rocketing-Systems Ltd.](https://github.com/marufdevops)

## :white_check_mark: Marking Criteria **[Total 150 points]**
- [ ] Features - **[100 points]**
- [ ] UI/UX - **[25 points]**
- [ ] Presentation + Q&A - **[25 points]**

# :bulb: Business Idea
As from 2019 lockdowns became the new normal, businesses and consumers increasingly went digital, providing and purchasing more goods and services online, raising global e-commerce to **$26.7** trillion! Our aim is to provide them with a platform where things can be easier to sell and consumers can have their product at a reasonable price. We are going to build a platform where every listed product(new/old) can be auctioned! We hope from here no customer has to buy their product with the unreasonable amount and bidding a product will be the new normal!
 
## :sparkles: Requirements

 1. **As an owner of the product**
	 - [ ] Ability to create an account with the listed pieces of information. **[Mandatory feature | 2.5 points]**
		 - [ ] First Name & Last Name
		 - [ ] Phone Number
		 - [ ] Select option for Roles: Seller or Buyer
		 - [ ] Implement Security Code based verification process while doing the registration
		 - [ ] Owner can then login anytime with the phone number using OTP verification
	- [ ]  Once the account creation is done, the owner needs to verify the account by providing the following pieces of information **[Nice to have | 7.5 points]**.
		- [ ] National Identity Number
		- [ ] Picture of the National Identity Number (Both Side)
		- [ ] `Note that this verification process should not block the owner ability to check any features of the platform`
		- [ ] `Only restriction should be if the profile is not verified, the owner can not sell a product through the platform and his profile will remain inactive.`
		- [ ] Once the profile is verified by the **Master Admin or Support Team**  of the platform, the profile of the owner will be activated for selling and customers can see their listed products
	- [ ] Owner Profile Informations (should have the ability to update) **[Mandatory feature | 5 points]**:
		- [ ] First Name & Last Name
		- [ ] Email 
		- [ ] Phone Number
		- [ ] Selling Points, selling points are based on the following criteria **(can't update)**:
			- [ ] Number of products he sold, **+2** for each product
			- [ ] Number of Good reviews, **+3** for each good review, **-3** for each bad review
			- [ ] Once the number of active points is below **0**, ~~owner will not be able to sell any products~~
			- [ ] Based on active point the products of the owner will be boosted and the product should appear in the first place within the platform
	- [ ]  Product listing requirements **[Mandatory feature | 10 points]**
		- [ ] Product Category
		- [ ] Product Name
		- [ ] Product Pictures (multiple)
		- [ ] Lowest price a customer can bid
		- [ ] A date for the expiration of the bid
		- [ ] Once the bid date get expired, no customer should be able to bid, if there is no winning bid seller can again open new bidding for the same product
		- [ ] Owner can set the criteria of winning bid
			- [ ] Owner can choose options, either Automated or Manual
				- [ ] Automated based formula (if marked as selected):
					- [ ] Highest bidder
					- [ ] Active points of the customer (a customer point is based on how often they buy products from this platform)
				- [ ] Manual Selection (if marked as selected):
					- [ ] Owner can choose anyone from the bidder
	- [ ] Payment Options **[Mandatory feature | 5 points]**
		- [ ] Owner will get paid through a payment gateway
			- [ ] Once they received the payment, they will start processing the delivery of the product
	- [ ] Notification **[Nice to have | 2.5 points]**
		- [ ] Owner will get notification/email on every bids
	- [ ] Generate a sales and revenue report **[Nice to have | 5 points]**
		- [ ] Owner can check his total revenue generated  
	- [ ] Premium User VS Freemium User (an owner can open a free account or can upgrade their account to have extra benefits) **[Nice to have | 15 points]**
		- [ ] Normal users can list at max 10 products within a month whereas for premium users it will be unlimited
		- [ ] For premium users the platform will boost their product to appear in the first place on the listing page or whenever customers do a search for the product
2. **As a Customer**
	- [ ] Ability to create an account with the listed pieces of information. **[Mandatory feature | 2.5 points]**
		 - [ ] First Name & Last Name
		 - [ ] Phone Number
		 - [ ] Select option for Roles: Seller or Buyer
		 - [ ] Implement Security Code based verification process while doing the registration
		 - [ ] Customer can then login anytime with the phone number using OTP verification
	- [ ]  Once the account creation is done, the customer needs to verify the account by providing the following pieces of information **[Nice to have | 7.5 points]**.
		- [ ] National Identity Number
		- [ ] Picture of the National Identity Number (Both Side)
		- [ ] `Note that this verification process should not block the customer ability to check any features of the platform`
		- [ ] `Only restriction should be if the profile is not verified, the customer can not bid a product through the platform and his profile will remain inactive.`
		- [ ] Once the profile is verified by the **Master Admin or Support Team**  of the platform, the profile of the customer will be activated for bidding
	- [ ] Customer Profile Informations (should have the ability to update) **[Mandatory feature | 5 points]**:
		- [ ] First Name & Last Name
		- [ ] Email 
		- [ ] Phone Number
		- [ ] Buying Points, buying points are based on the following criteria **(can't update)**:
			- [ ] Number of products he purchased, **+2** for each product
			- [ ] Number of Good reviews, **+3** for each good review, **-3** for each bad review
			- [ ] Once the number of active points is below **0**, ~~owner will not be able to sell any products~~
	- [ ] Product View **[Mandatory feature | 10 points]**
		- [ ] Customer can see all the listed products on the platform with details
		- [ ] Customer can search product by name/brand/category/location
		- [ ] Customer can put a bid for the product, a bid can be placed either through input box or some kind of slider in terms of UI/UX
		- [ ] A customer can bid only once for the specific product
	- [ ] Notification **[Nice to have | 2.5 points]**
		- [ ] If a customer owns the bid he will be notified either through email or SMS
	- [ ] Payment Options **[Mandatory feature | 5 points]**
		- [ ] Customer will pay the product owner through a payment gateway
			- [ ] Once they paid, the owner of the product will start delivery of the product.
	- [ ] Premium User VS Freemium User (customer can open a free account or can upgrade their account to have extra benefits) **[Nice to have | 15 points]**
		- [ ] Normal users can only bid whereas premium users can see the percentage of winning a bid

## Our Solution

![image](https://user-images.githubusercontent.com/86300358/144703314-472a4dc7-fb36-4814-948d-45d4a813c740.png)


![1-Title](https://user-images.githubusercontent.com/86300358/144703157-0774be93-d786-4d1c-8170-ce1182f7862a.jpg)
![2-Proposed-Strategy](https://user-images.githubusercontent.com/86300358/144703243-8b88cac4-8c0b-43c1-9afa-084031279536.jpg)
![3-Current-Marketing-Mix-copy-1](https://user-images.githubusercontent.com/86300358/144703247-38a2fb40-257f-479f-9c3c-c22e0bf1e188.jpg)
![4-Current-Marketing-Mix](https://user-images.githubusercontent.com/86300358/144703251-a58fdb2f-1e82-4d55-af9d-b15620dc0e18.jpg)
![5-Current-Marketing-Mix-copy-14](https://user-images.githubusercontent.com/86300358/144703254-ada8e31f-4c41-444b-9f92-cd8a67c33639.jpg)
![6-Current-Marketing-Mix-copy-6](https://user-images.githubusercontent.com/86300358/144703257-0e4aec1b-2b10-4139-85b4-63881ebcc9cc.jpg)
![7-Current-Marketing-Mix-copy-7](https://user-images.githubusercontent.com/86300358/144703264-b22a16d8-e810-40da-8eac-55dab1f844b4.jpg)
![8-Current-Marketing-Mix-copy-16](https://user-images.githubusercontent.com/86300358/144703268-b485f0a7-7559-4276-ac24-8db933fd2445.jpg)
![9-Current-Marketing-Mix-copy-3](https://user-images.githubusercontent.com/86300358/144703273-f237d575-11e3-4d77-8cbd-761bd36dea07.jpg)
![10-Current-Marketing-Mix-copy-4](https://user-images.githubusercontent.com/86300358/144703276-1874a160-2a69-4768-9eca-a1551c74d3eb.jpg)
![11-Current-Marketing-Mix-copy-15](https://user-images.githubusercontent.com/86300358/144703279-13383d53-3182-4f5b-85e9-e05ced381b6b.jpg)
![12-Current-Marketing-Mix-copy-11](https://user-images.githubusercontent.com/86300358/144703282-0870f60c-48bf-44c9-9022-8b013b92b72a.jpg)
![13-About-Us](https://user-images.githubusercontent.com/86300358/144703402-8796abc7-b623-4111-926f-a04cb04a35ae.jpg)
![14-Thank-You](https://user-images.githubusercontent.com/86300358/144703409-2a4ded5c-2592-47a8-a499-011848e825d2.jpg)

