# Changelog

All notable changes to this project will be documented in this file.

## [Unreleased] - 2026-05-12

### Added
- `DataProcessingException` class for unified error handling in I/O and data conversion operations.
- Lombok dependency to reduce boilerplate code.
- `CHANGELOG.md` to track project history.

### Changed
- **Git Branch Cleanup**: 
    - Created `dev` branch from `master`.
    - Merged `feature/report-generator` into `dev`.
    - Deleted redundant local and remote branches (`alex`, `feature-dataconverter`, `feature/handler`, `feature/main-class`, `feature/report-generator`, `final`, `lisandr`, `feature/csv-data-validator`).
- **Refactoring**:
    - `FruitTransaction` now uses Lombok `@Getter` and `@AllArgsConstructor`.
    - `LineReader` and `ReportWriter` interfaces updated to use runtime exceptions (`DataProcessingException`) instead of checked `IOException`.
    - `DataConverterImpl` updated to throw `DataProcessingException` on malformed CSV or parse errors.
    - `Main` class updated to use constants for default file paths and simplified exception handling.
- **Code Style**:
    - Fixed Checkstyle violations (line length).
    - Verified code with `mvn checkstyle:check`.

### Fixed
- Inconsistent architecture across feature branches by consolidating into a single `dev` branch.
- Generic `Exception` catching in `DataConverterImpl`.

### Security
- Verified that no sensitive data or credentials are present in the codebase.
