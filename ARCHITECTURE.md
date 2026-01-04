# Architecture

This document outlines the architectural choices for the Calibre API.

## Layers

The application follows a standard layered architecture:

- **Controller:** Exposes the REST API endpoints.
- **Service:** Contains the business logic.
- **Repository:** Handles data access using Spring Data JPA.
- **Domain:** Contains the JPA entities.
- **DTO:** Data Transfer Objects used to transfer data between layers.
- **Mapper:** Maps between entities and DTOs using MapStruct.

## API Design

The API is designed to be RESTful and stateless.

### Book Endpoint

The `/api/books/{id}` endpoint provides different levels of detail based on the `view` query parameter:

- **`GET /api/books/{id}` (Default View):** Returns the book entity's data, but for linked entities (publisher, series, authors, tags), only their IDs are included.
- **`GET /api/books/{id}?view=summary` (Summary View):** Returns the book entity's data, but for publisher and series, it includes their `id` and `name`. For authors and tags, it includes a list of objects, each containing an `id` and `name`.
- **`GET /api/books/{id}?view=detail` (Detail View):** This is an extension of the summary view, but it also includes data for "formats" (`id`, `name`, `path`) and the complete "comment".
