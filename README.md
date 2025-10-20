# Compass assesment
Find duplicates in csv in java

## Assessment Solution

This repository contains a solution for identifying potential duplicate contacts in a dataset. The implementation follows all requirements specified in the assessment.

## Time Allocation
4 hours

## Requirements

The solution addresses the following requirements:
1. Identify which contacts are possible matches
2. Provide a score for each match representing match accuracy
3. Handle cases where a contact might have multiple or no matches
4. Process all data in working memory (no database)

## Implementation Overview

### Algorithm
The solution uses the Jaro-Winkler string similarity algorithm, which is particularly effective for:
- Short strings like names
- Addresses with similar patterns
- Email comparison

The matching process considers multiple fields (name, email, address) with configurable weights to determine an overall match score.

### Accuracy Scoring
Match accuracy is determined using a weighted scoring system:

The scoring systems sums name * 10 + lastName * 10 + zip + address * 100 + emailAddress * 100
Then it is normalized between 0 and 1
Also when the address or mail are equal it matches as High inmediately

- **High**: Match score ≥ 0.8
- **Medium**: Match score ≥ 0.5
- **Low**: Match score less than 0.5

### Example

As shown in the assessment example:

**Input:**
| Contact ID | First Name | Last Name | Email Address | Zip Code | Address |
|------------|------------|-----------|---------------|----------|---------|
| 1001 | C | F | mollis.lectus.pede@outlook.net | | 449-6990 Tellus. Rd. |
| 1002 | C | French | mollis.lectus.pede@outlook.net | 39746 | 449-6990 Tellus. Rd. |
| 1003 | Ciara | F | non.lacinia.at@zoho.ca | 39746 | |

**Output:**
| ContactID Source | ContactID Match | Accuracy |
|------------------|----------------|----------|
| 1001 | 1002 | High |
| 1001 | 1003 | Low |

## Dependencies

The implementation uses minimal external dependencies:
- com.opencsv to import Csv
- org.apache.commons to use JaroWinkler match

## Performance Considerations

- Field normalization could be applied before comparison to improve match quality
- Early termination for obvious non-matches reduces processing time
- Optimized for in-memory processing of moderate-sized datasets
