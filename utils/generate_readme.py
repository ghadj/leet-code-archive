import os
import re

def extract_javadoc(java_file_path):
    with open(java_file_path, 'r', encoding='utf-8') as f:
        content = f.read()

    # Regex to find the Javadoc block
    match = re.match(r"/\*\*((?:.|\n)*?)\*/", content)
    if not match:
        return None, content

    javadoc = match.group(1)
    # Remove the Javadoc block from the file content
    cleaned_content = content[match.end():].lstrip()

    return javadoc, cleaned_content

def clean_javadoc(javadoc):
    # Remove leading asterisks and whitespace
    lines = javadoc.strip().splitlines()
    cleaned_lines = [line.strip().lstrip('*').strip() for line in lines]

    # Extract URL and title
    url = ""
    title = ""
    for line in cleaned_lines:
        if line.startswith('[') and ']' in line and 'http' in line:
            url = line.strip("[]")
        elif re.match(r"^\d+\.\s", line):
            title = line.strip()
            break

    description = "\n".join(cleaned_lines[2:])  # Skip link and title lines

    return url, title, description

def process_java_files(directory):
    readme_content = []
    for file in os.listdir(directory):
        if file.endswith(".java"):
            java_file_path = os.path.join(directory, file)
            javadoc, cleaned_content = extract_javadoc(java_file_path)
            if javadoc:
                url, title, description = clean_javadoc(javadoc)
                if url and title:
                    readme_entry = f"## [{title}]({url})\n\n{description}\n"
                    readme_content.append(readme_entry)

                    # Overwrite Java file without the Javadoc
                    with open(java_file_path, 'w', encoding='utf-8') as f:
                        f.write(cleaned_content)

    # Write README.md if we have content
    if readme_content:
        readme_path = os.path.join(directory, "README.md")
        with open(readme_path, 'w', encoding='utf-8') as f:
            f.write("# Problem Descriptions\n\n")
            f.write("\n---\n\n".join(readme_content))

def main(root_dir):
    for entry in os.listdir(root_dir):
        subdir_path = os.path.join(root_dir, entry)
        if os.path.isdir(subdir_path):
            process_java_files(subdir_path)

if __name__ == "__main__":
    import sys
    if len(sys.argv) != 2:
        print("Usage: python generate_readmes.py <root_directory>")
    else:
        main(sys.argv[1])
