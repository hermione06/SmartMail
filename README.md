

# Smart Mail Generator

## Overview

Smart Mail Generator is an intelligent email reply generator built using **Spring Boot** and **Spring AI Gemini API**. It automates email responses by analyzing the incoming email's context and generating appropriate, professional, and context-aware replies.

## Features

- **AI-powered Email Reply Generation**: Uses Gemini AI to craft well-structured responses.
- **Spring Boot Framework**: Ensures a scalable and maintainable backend.
- **Context-aware Responses**: Understands the incoming email's tone and content.
- **Customizable Reply Style**: Allows users to tweak the response tone (formal, friendly, etc.).
- **RESTful API**: Provides endpoints for integration with email services.

## Tech Stack

- **Java 23** (Spring Boot)
- **Spring AI Gemini API**
- **Gradle** for dependency management

## Installation & Setup

### Prerequisites

- Java 17+
- Gradle
- A valid API key for **Gemini API**

### Steps

1. **Clone the repository**:

   ```bash
   git clone https://github.com/yourusername/SmartMail.git
   cd SmartMail
   ```

2. **Configure API Key**:

   Add your Gemini API key to `application.properties` or as an environment variable:

   ```properties
   spring.ai.gemini.api-key=YOUR_API_KEY
   ```

3. **Build and Run**:

   ```bash
  ./gradlew build
  ./gradlew bootRun
   ```

4. **Access the API**:

   - Default URL: `http://localhost:8080`
   - OpenAPI docs (if enabled): `http://localhost:8080/swagger-ui.html`

## API Endpoints

### Generate Reply

**POST** `/api/email/reply`

#### Request Body:

```json
{
  "emailContent": "Hello, can you confirm the meeting time for tomorrow?",
  "tone": "formal"
}
```

#### Response:

```json
{
  "generatedReply": "Dear [Name],\n\nThank you for reaching out. The meeting is scheduled for tomorrow at [time]. Please let me know if you need any changes.\n\nBest regards,\n[Your Name]"
}
```


## Contribution

Feel free to fork, submit PRs, and suggest improvements. 

## License

MIT License © 2025 Asiman Ismayilova

