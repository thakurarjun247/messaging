#Now, you can run the script like this:

# sh git.sh "Your commit message here"

echo "\ngit pull..."  
git pull

git add .

#echo "\ngit status..."
#git status

# Check if a commit message is provided as a command-line argument
if [ -n "$1" ]; then
  commitMessage="$1"
else
  echo "\nEnter a commit message:"
  read commitMessage
fi

git commit -m "$commitMessage"

echo "\ngit push..."  
git push

echo "Finished!"