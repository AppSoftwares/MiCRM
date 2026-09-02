# MiCRM — Obsidian Monolith Edition

![MiCRM Premium Dark](Mi%20CRM%20Logo/MiCRM_preview.png)

**MiCRM** is a high-performance, premium dark-themed CRM platform designed for sophisticated workflows and exclusive user experiences. Built with a focus on high-fidelity visuals and top-tier security, it provides an effortless way to manage contacts, pipelines, and tasks in a distraction-free environment.

## ✨ The Vision: Obsidian Monolith
MiCRM follows the **Obsidian Monolith** design system—a "Hyper-Premium Dark" aesthetic characterized by:
- **Pure Black Foundation:** Optimized for OLED screens and infinite contrast.
- **Brushed Metal Textures:** Radial gradients that simulate physical materials.
- **Swipeable Card Stacks:** A tactile, card-based interface for fluid data management.
- **Minimalist Data Viz:** Clean, axis-free charts that focus on trends, not noise.

## 🚀 Key Features
- **Smart Dashboard:** High-level KPIs and minimalist revenue forecasting.
- **Fluid Pipeline:** Kanban-style lead management with drag-and-drop mechanics.
- **Advanced Contacts:** Deep relationship tracking with activity timelines.
- **Task Deck:** A swipeable deck of pending tasks with smart completion gestures.
- **Bank-Grade Security:** Encrypted local storage using Room + SQLCipher.

## 🛠 Tech Stack
- **Native UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) for ultra-smooth animations and premium styling.
- **Hybrid Bridge:** [Capacitor](https://capacitorjs.com/) base for cross-platform synchronization.
- **Database:** [Room](https://developer.android.com/training/data-storage/room) with **SQLCipher** for full database encryption.
- **Architecture:** MVVM (Model-View-ViewModel) for clean separation of concerns.
- **DevOps:** Automated CI/CD workflows via GitHub Actions for `.apk` and `.ipa` distribution.

## 📦 Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/AppSoftwares/MiCRM.git
   cd MiCRM
   ```

2. **Install dependencies:**
   ```bash
   pnpm install
   ```

3. **Build and Sync:**
   ```bash
   pnpm run build
   npx cap sync android
   ```

4. **Run on Android:**
   Open the `android` folder in Android Studio and run the `app` module.

## 🔒 Security Best Practices
- **No Backups:** `android:allowBackup="false"` to prevent unauthorized data extraction.
- **Secure Paths:** Strict `FileProvider` configuration to avoid storage root exposure.
- **Encrypted DB:** Every byte written to the local database is encrypted at rest.

---

*Developed with ❤️ by [AppSoftwares](https://github.com/AppSoftwares)*
