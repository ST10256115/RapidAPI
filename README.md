# WeatherCast (Android, Retrofit + OkHttp)

## Why this API?
I chose **Open-Meteo** because it:
- **Requires no API key and no credit card**, so the project is easy to run for assessors and teammates.
- Is **reliable and fast**, with a clear schema for hourly/daily weather.
- Exposes **useful real-world data** (temperature, wind, precipitation), making it perfect for mobile use cases like trip planning, outdoor activities, and daily routines.

## Why a mobile app with this data is relevant
Weather drives everyday decisions. A focused Android app can:
- Give **hyper-local, on-the-go** forecasts for a user’s chosen coordinates.
- Provide **quick hourly snapshots** so users can plan commutes, workouts, or deliveries.
- Cache recent results to be **snappy and data-friendly** on mobile networks.

## Tech stack
- **Kotlin + Jetpack Compose** for the UI
- **Retrofit** for HTTP calls
- **OkHttp** with logging for diagnostics
- **Moshi** for JSON parsing
- **MVVM** with a ViewModel and Repository

## API details
- Base URL: `https://api.open-meteo.com/v1/`
- Endpoint example: `/forecast?latitude=-29.8587&longitude=31.0218&hourly=temperature_2m&timezone=auto`

## How to run
1. Open the project in Android Studio (Electric Eel+).
2. Ensure Internet permission exists in `AndroidManifest.xml`:
   ```xml
   <uses-permission android:name="android.permission.INTERNET" />
