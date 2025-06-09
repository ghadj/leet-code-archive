#!/bin/bash

# Traverse all folders in current directory
for dir in */; do
  dir=${dir%/}  # Remove trailing slash

  # Find the first .java file in the directory
  java_file=$(find "$dir" -maxdepth 1 -name "*.java" | head -n 1)

  if [[ -n "$java_file" ]]; then
    # Extract the target name from the LeetCode URL in the comment
    target_name=$(sed -n 's|.*https://leetcode.com/problems/\([^]/]*\).*|\1|p' "$java_file" | head -n 1)

    if [[ -n "$target_name" && "$dir" != "$target_name" ]]; then
      # Avoid renaming to the same name or overwriting existing directories
      if [[ ! -d "$target_name" ]]; then
        echo "Renaming '$dir' -> '$target_name'"
        mv "$dir" "$target_name"
      else
        echo "Skipping '$dir' - Target folder '$target_name' already exists."
      fi
    fi
  fi
done

