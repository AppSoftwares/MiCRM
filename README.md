# MiCRM — Edición Obsidian Monolith

![MiCRM Premium Dark](Mi%20CRM%20Logo/MiCRM_preview.png)

**MiCRM** es una plataforma de gestión de relaciones con el cliente (CRM) de alto rendimiento con un diseño de tema oscuro premium, creada para flujos de trabajo sofisticados y experiencias de usuario exclusivas. Construida con un enfoque en visuales de alta fidelidad y seguridad de primer nivel, proporciona una manera sin esfuerzo de gestionar contactos, oportunidades de negocio (pipeline) y tareas en un entorno libre de distracciones.

## ✨ La Visión: Obsidian Monolith
MiCRM sigue el sistema de diseño **Obsidian Monolith**, una estética "Hyper-Premium Dark" caracterizada por:
- **Base Negro Puro:** Optimizado para pantallas OLED y contraste infinito.
- **Texturas de Metal Cepillado:** Gradientes radiales que simulan materiales físicos reales.
- **Pilas de Tarjetas Deslizables:** Una interfaz táctil basada en tarjetas para una gestión de datos fluida.
- **Visualización de Datos Minimalista:** Gráficos limpios, sin ejes, que se centran en las tendencias, eliminando el ruido visual.

## 🚀 Características Principales
- **Dashboard Inteligente:** KPIs de alto nivel y pronósticos de ingresos minimalistas.
- **Pipeline Fluido:** Gestión de prospectos tipo Kanban con mecánicas de arrastrar y soltar.
- **Contactos Avanzados:** Seguimiento profundo de relaciones con líneas de tiempo de actividad.
- **Mazo de Tareas:** Un mazo deslizable de tareas pendientes con gestos inteligentes de completado.
- **Seguridad Grado Bancario:** Almacenamiento local cifrado mediante Room + SQLCipher.

## 🛠 Stack Tecnológico
- **UI Nativa:** [Jetpack Compose](https://developer.android.com/jetpack/compose) para animaciones ultra fluidas y estilo premium.
- **Puente Híbrido:** Base de [Capacitor](https://capacitorjs.com/) para sincronización multiplataforma.
- **Base de Datos:** [Room](https://developer.android.com/training/data-storage/room) con **SQLCipher** para el cifrado total de la base de datos en reposo.
- **Arquitectura:** MVVM (Model-View-ViewModel) para una separación clara de responsabilidades.
- **DevOps:** Flujos de CI/CD automatizados a través de GitHub Actions para la distribución de archivos `.apk` y `.ipa`.

## 📦 Instalación y Configuración

1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/AppSoftwares/MiCRM.git
   cd MiCRM
   ```

2. **Instalar dependencias:**
   ```bash
   pnpm install
   ```

3. **Construir y Sincronizar:**
   ```bash
   pnpm run build
   npx cap sync android
   ```

4. **Ejecutar en Android:**
   Abre la carpeta `android` en Android Studio y ejecuta el módulo `app`.

## 🔒 Mejores Prácticas de Seguridad
- **Sin Respaldos:** `android:allowBackup="false"` para evitar la extracción no autorizada de datos.
- **Rutas Seguras:** Configuración estricta de `FileProvider` para evitar la exposición de la raíz del almacenamiento.
- **BD Cifrada:** Cada byte escrito en la base de datos local se cifra automáticamente.

---

*Desarrollado con ❤️ por [AppSoftwares](https://github.com/AppSoftwares)*
