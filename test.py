import os
import random
from datetime import datetime, timedelta

def makeCommits(random_days: int) -> int:
    if random_days < 1:
        os.system('git push')
        return 0
    else:
        # Generate a random number of days within the past year
        days_ago = random.randint(1, 365)
        commit_date = datetime.now() - timedelta(days=days_ago)
        dates = commit_date.strftime('%Y-%m-%d %H:%M:%S')

        for _ in range(2):  # Commit twice for each day
            with open('data.txt', 'a') as file:
                file.write(f'{dates} <- this was the commit for the day!!')

            # staging
            os.system('git add data.txt')

            # commit
            commit_message = f"Commit for the day {dates}"
            os.system(f'git commit --date="{dates}" -m "{commit_message}"')

        # recursive call
        return 2 + makeCommits(random_days - 1)

total_commits = makeCommits(10)  # Change 10 to the desired number of random commits
print(f'Total commits made: {total_commits}')
