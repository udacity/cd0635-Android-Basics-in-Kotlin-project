# 🐾 PawHaven — Starter Project

Welcome to **PawHaven** 🏡🐶🦁  
You are building an Android app for a very special animal shelter — one that welcomes **all animals**, from dogs and cats to parrots, lions, and birds.

This starter project gives you helpful pieces, but **you are the builder**.  
Your goal is to bring PawHaven to life by completing the missing parts step by step.

Take your time. Read carefully. Have fun 🌈

---

## 🌟 What You’re Building

By the end of this project, your app will:

- Let users create a profile
- Show a list of animals in the shelter
- Let users tap an animal to see details
- Play animal sounds (woof 🐶, meow 🐱, roar 🦁)
- Allow volunteers to take special actions
- Work in **English and French**
- Adapt to phones **and** tablets

---

## 🧩 What’s Already Provided

You are **not starting from scratch**. These pieces are ready for you:

### 🔊 PlayPauseComponent
- A reusable UI component that handles **play / pause** for sounds
- Only one sound should play at a time
- You must **use this component** — do not write your own sound logic

---

### 🌍 Language Support (English & French)
- All strings are already provided in:
  - English 🇺🇸
  - French 🇫🇷
- Language switching is already handled in `AbstractBaseActivity`
- Your job is to **use string resources**, never hardcoded text

---

### 🧑 Profile & Roles
- A `Profile` (Person) model is provided with:
  - `firstName`
  - `lastName`
  - `age`
  - `role`
- A `Role` enum exists:
  - `VOLUNTEER`
  - `INTERESTED_PARENT`
- A list of **valid volunteers** is already provided

Rules:
- Interested Parents can always continue
- Volunteers must be validated against the provided list

---

### 🐾 Animal Defaults
- An `AnimalType` enum is provided with default:
  - image
  - sound
- Supported types include:
  - Dog 🐶
  - Cat 🐱
  - Lion 🦁
  - Parrot 🦜
  - Bird 🐦
- Default icons and sounds are included

---

### 📦 Repository
A simple `Repository` is provided with:
- `user` (currently `null`)
- `pets` (`MutableList<Animal>`)

You will:
- Save the logged-in user here
- Add new animals to this list
- Use it as your single source of truth

---

## ✨ What You Must Implement

Below are the **project expectations**, written in a friendly way so you know exactly what to build.

---

## 🧠 Section 1: Kotlin & Object-Oriented Design

### 🎯 Goal
You will learn how to model real-world ideas (animals and people) using Kotlin classes.

### ✅ Requirements
- Create an **abstract** `Animal` parent class
- Constructor must include:
  - `name: String`
  - `age: Int`
  - `description: String`
  - `imageRes: Int`
  - `soundRes: Int`
- Every `Animal` must have:
  - `id: String = UUID.randomUUID().toString()`
- `Animal` **cannot** be created directly
- Create animal subclasses (Dog, Cat, Lion, Zebra, etc.)
- Subclasses should:
  - Use default images and sounds from `AnimalType`
  - Allow optional overrides
- You may add **new animal types**
- Use the provided `Person` data class and `Role` enum

💡 Tip:  
If you see repeated code in subclasses, move it to the parent class.

---

## 📱 Section 2: Android UI, Navigation & Lifecycle

### 🎯 Goal
You will build a multi-screen Android app that works on phones and tablets.

---

### 🏁 MainActivity (Welcome Screen)
- Uses `LinearLayout`
- Matches the provided UX
- Is the **launcher activity**
- “Get Started” navigates to **ProfileActivity**

---

### 👤 ProfileActivity
- Inputs:
  - First name
  - Last name
  - Age
  - Role (Interested Parent or Volunteer)
- Validations:
  - Name and age must not be empty
  - Age must be a number
  - Volunteers must exist in the volunteer list
- Save the user to `Repository.user`
- Navigate to `PetListActivity`

---

### 🐕 PetListActivity
- Phone:
  - Shows only the list
- Tablet:
  - Shows list + detail (two-pane)
- Uses `sw600dp` resources
- Hosts:
  - `PetListFragment`
  - `PetDetailFragment` (tablet only)
- Implements `PetListFragment.Host`:
  - `onPetSelected(pet)`
  - `onAddClicked()`
  - `isTwoPane()`
- Add FAB:
  - Visible **only** if user is a Volunteer
  - Opens `AddAnimalActivity`
- New animals:
  - Inserted at index `0`
  - List refreshes automatically
- Rotation:
  - Animal list must survive rotation

---

### 🧩 PetListFragment
- Displays list of animals
- Matches UX
- Phone only:
  - Shows play button
- Tablet:
  - **No play button** in list
- Exposes:
  - `refreshPetList()`
- Tapping a row calls `onPetSelected`

---

### 🐾 PetDetailFragment / Activity
- Displays:
  - Image
  - Description
  - Play button
  - Optional share button
  - “Adopt A Paw” button
- “Adopt A Paw”:
  - Only visible for Volunteers
  - Shows a Toast when clicked

---

### ➕ AddAnimalActivity
- Matches UX
- Allows selecting animal type
- Updates preview image and sound
- Returns new `Animal` via Intent extras

---

## 🎨 Section 3: Custom & Reusable Views

### 🎯 Goal
You will learn how to reuse UI components and integrate custom views.

### ✅ Requirements
- Use **PlayPauseView** in XML
- Do not reimplement sound logic
- Create a reusable **PetRowComponent**
  - XML layout defined
  - Used consistently in the list

💡 Tip:  
Custom views don’t need to be fancy — correctness matters more than visuals.

---

## 🌟 Stand-Out Ideas (Optional)
Want to go further?

- Support deep links like:
  - `pawhaven://animal/{index}`
- Add a share button in details
- Add more languages
- Let users edit their profile later
- Hide play button automatically in list when in two-pane mode

---

## 🐶 Final Words

PawHaven is your playground for learning Android.

Build it step by step.  
Test often.  
And remember — every animal deserves a home 💖

You’ve got this 🚀
